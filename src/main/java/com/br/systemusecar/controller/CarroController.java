package com.br.systemusecar.controller;

import com.br.systemusecar.Exceptions.ExceptionConflict;
import com.br.systemusecar.model.Carro;
import com.br.systemusecar.services.CarroService;
import com.br.systemusecar.utils.RegrasAdmins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@Transactional
@RequestMapping("/admin")
public class CarroController {

    @Autowired
    CarroService carroService;


    //    @PreAuthorize("hasAnyAuthority(RegrasAdmins.LISTAR)")
    @PreAuthorize("hasAnyAuthority('"+ RegrasAdmins.LISTAR+"')")
    @RequestMapping(value = "/api/cars",method = RequestMethod.GET)
    public ModelAndView produtoList(@SortDefault(value = "id") @PageableDefault(size = 15) Pageable pageable, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/carro/listarCarro");

        Page<Carro> carro = carroService.pesquisaTodosCarros(pageable);
        mv.addObject("carro", carro);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(value = "/api/cars/adicionar",method = RequestMethod.GET)
    public ModelAndView produtoAdicionar(Carro carro) {
        ModelAndView mv = new ModelAndView("pages/carro/formCarro");

        mv.addObject("carro", carro);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.MOSTRAR+"')")
    @RequestMapping(value = "/carro/{id}", method = RequestMethod.GET)
    public ModelAndView produtoShow(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/carro/formCarro");

        Optional<Carro> produto = carroService.recuperarCarro(id);

        if (!produto.isPresent()) {
            attributes.addFlashAttribute("mensagemErro", "Carro não existe");

            new ModelAndView("redirect:/admin/carro");
        }

        mv.addObject("carro", produto.get());
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(method = RequestMethod.POST, value = "/carro/save")
    public ModelAndView produtoSave(@Valid @ModelAttribute("produto") Carro carro, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors().toString());
            return produtoAdicionar(carro);
        }
        try {
            carroService.salvaCarro(carro);
            attributes.addFlashAttribute("mensagem", "Dados salvos com sucesso.");
            return new ModelAndView("redirect:/admin/carro/");
        } catch (ExceptionConflict e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
            return new ModelAndView("redirect:/admin/carro/adicionar");
        }
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.EXCLUIR+"')")
    @RequestMapping(value = "/carro/excluir/{id}", method = RequestMethod.GET)
    public String produtoDeletar(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {

        try {
            carroService.apagarCarro(id);
            attributes.addFlashAttribute("mensagem", "Carro excluido com sucesso");
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {

            attributes.addFlashAttribute("mensagemErro", "Carro não excluido. Um erro aconteceu durante a exclusão");

            return "redirect:/admin/carro";
        }


        return "redirect:/admin/carro";
    }
}
