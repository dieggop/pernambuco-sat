package com.br.carrilho.silva.pernambucosat.controller;

import com.br.carrilho.silva.pernambucosat.Exceptions.ExceptionConflict;
import com.br.carrilho.silva.pernambucosat.model.Categoria;
import com.br.carrilho.silva.pernambucosat.services.CategoriaService;
import com.br.carrilho.silva.pernambucosat.utils.RegrasAdmins;
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
public class CategoriasController {

    @Autowired
    CategoriaService categoriaService;


    //    @PreAuthorize("hasAnyAuthority(RegrasAdmins.LISTAR)")
    @PreAuthorize("hasAnyAuthority('"+ RegrasAdmins.LISTAR+"')")
    @RequestMapping(value = "/categorias",method = RequestMethod.GET)
    public ModelAndView categoriaList(@SortDefault(value = "id") @PageableDefault(size = 15) Pageable pageable, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/categorias/listarCategorias");

        Page<Categoria> categorias = categoriaService.pesquisaTodasCategorias(pageable);
        mv.addObject("categorias", categorias);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(value = "/categorias/adicionar",method = RequestMethod.GET)
    public ModelAndView categoriaAdicionar(Categoria categoria) {
        ModelAndView mv = new ModelAndView("pages/categorias/formCategorias");

        mv.addObject("categoria", categoria);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.MOSTRAR+"')")
    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.GET)
    public ModelAndView categoriaShow(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/categorias/formCategorias");

        Optional<Categoria> categoria = categoriaService.recuperarCategoria(id);

        if (!categoria.isPresent()) {
            attributes.addFlashAttribute("mensagemErro", "Categoria não existe");

            new ModelAndView("redirect:/admin/categorias");
        }

        mv.addObject("categoria", categoria.get());
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(method = RequestMethod.POST, value = "/categorias/save")
    public ModelAndView categoriaSave(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return categoriaAdicionar(categoria);
        }
        try {
            categoriaService.salvaCategoria(categoria);
            attributes.addFlashAttribute("mensagem", "Dados salvos com sucesso.");
            return new ModelAndView("redirect:/admin/categorias/");
        } catch (ExceptionConflict e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
            return new ModelAndView("redirect:/admin/categorias/adicionar");
        }
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.EXCLUIR+"')")
    @RequestMapping(value = "/categorias/excluir/{id}", method = RequestMethod.GET)
    public String categoriaDeletar(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {

        try {
            categoriaService.apagarCategoria(id);
            attributes.addFlashAttribute("mensagem", "Categoria excluida com sucesso");
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {

            attributes.addFlashAttribute("mensagemErro", "Categoria não excluida. Um erro aconteceu durante a exclusão");

            return "redirect:/admin/categorias";
        }


        return "redirect:/admin/categorias";
    }
}
