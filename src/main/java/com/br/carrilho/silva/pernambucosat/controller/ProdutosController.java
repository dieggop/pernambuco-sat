package com.br.carrilho.silva.pernambucosat.controller;

import com.br.carrilho.silva.pernambucosat.Exceptions.ExceptionConflict;
import com.br.carrilho.silva.pernambucosat.model.Produto;
import com.br.carrilho.silva.pernambucosat.services.ProdutoService;
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
public class ProdutosController {

    @Autowired
    ProdutoService produtoService;


    //    @PreAuthorize("hasAnyAuthority(RegrasAdmins.LISTAR)")
    @PreAuthorize("hasAnyAuthority('"+ RegrasAdmins.LISTAR+"')")
    @RequestMapping(value = "/produtos",method = RequestMethod.GET)
    public ModelAndView produtoList(@SortDefault(value = "id") @PageableDefault(size = 15) Pageable pageable, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/produtos/listarProdutos");

        Page<Produto> produtos = produtoService.pesquisaTodosProdutos(pageable);
        mv.addObject("produtos", produtos);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(value = "/produtos/adicionar",method = RequestMethod.GET)
    public ModelAndView produtoAdicionar(Produto produto) {
        ModelAndView mv = new ModelAndView("pages/produtos/formProdutos");

        mv.addObject("produto", produto);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.MOSTRAR+"')")
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ModelAndView produtoShow(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/produtos/formProdutos");

        Optional<Produto> produto = produtoService.recuperarProduto(id);

        if (!produto.isPresent()) {
            attributes.addFlashAttribute("mensagemErro", "Produto não existe");

            new ModelAndView("redirect:/admin/produtos");
        }

        mv.addObject("produto", produto.get());
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(method = RequestMethod.POST, value = "/produtos/save")
    public ModelAndView produtoSave(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors().toString());
            return produtoAdicionar(produto);
        }
        try {
            produtoService.salvaProduto(produto);
            attributes.addFlashAttribute("mensagem", "Dados salvos com sucesso.");
            return new ModelAndView("redirect:/admin/produtos/");
        } catch (ExceptionConflict e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
            return new ModelAndView("redirect:/admin/produtos/adicionar");
        }
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.EXCLUIR+"')")
    @RequestMapping(value = "/produtos/excluir/{id}", method = RequestMethod.GET)
    public String produtoDeletar(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {

        try {
            produtoService.apagarProduto(id);
            attributes.addFlashAttribute("mensagem", "Produto excluida com sucesso");
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {

            attributes.addFlashAttribute("mensagemErro", "Produto não excluida. Um erro aconteceu durante a exclusão");

            return "redirect:/admin/produtos";
        }


        return "redirect:/admin/produtos";
    }
}
