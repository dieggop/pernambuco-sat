package com.br.systemusecar.controller;

import com.br.systemusecar.Exceptions.ExceptionConflict;
import com.br.systemusecar.model.Usuario;
import com.br.systemusecar.services.UsuarioService;
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
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    //    @PreAuthorize("hasAnyAuthority(RegrasAdmins.LISTAR)")
    @PreAuthorize("hasAnyAuthority('"+ RegrasAdmins.LISTAR+"')")
    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public ModelAndView categoriaList(@SortDefault(value = "id") @PageableDefault(size = 15) Pageable pageable, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/usuario/listarUsuarios");

        Page<Usuario> usuario = usuarioService.pesquisaTodasUsuarios(pageable);
        mv.addObject("usuario", usuario);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(value = "/api/users/adicionar",method = RequestMethod.GET)
    public ModelAndView usuarioAdicionar(Usuario usuario) {
        ModelAndView mv = new ModelAndView("pages/usuario/formUsuario");

        mv.addObject("usuario", usuario);

        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.MOSTRAR+"')")
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public ModelAndView usuarioShow(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {
        ModelAndView mv = new ModelAndView("pages/usuario/formUsuario");

        Optional<Usuario> categoria = usuarioService.recuperarUsuario(id);

        if (!categoria.isPresent()) {
            attributes.addFlashAttribute("mensagemErro", "Usuario não existe");

            new ModelAndView("redirect:/admin/usuario");
        }

        mv.addObject("categoria", categoria.get());
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.ADICIONAR+"')")
    @RequestMapping(method = RequestMethod.POST, value = "/api/users/{id}")
    public ModelAndView usuarioSave(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return usuarioAdicionar(usuario);
        }
        try {
            usuarioService.salvaUsuario(usuario);
            attributes.addFlashAttribute("mensagem", "Dados salvos com sucesso.");
            return new ModelAndView("redirect:/admin/usuario/");
        } catch (ExceptionConflict e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
            return new ModelAndView("redirect:/admin/usuario/adicionar");
        }
    }

    @PreAuthorize("hasAnyAuthority('"+RegrasAdmins.EXCLUIR+"')")
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public String categoriaDeletar(@PathVariable("id") Long id, RedirectAttributes attributes, Principal principal) {

        try {
            usuarioService.apagarUsuario(id);
            attributes.addFlashAttribute("mensagem", "Usuario excluido com sucesso");
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {

            attributes.addFlashAttribute("mensagemErro", "Usuario não excluido. Um erro aconteceu durante a exclusão");

            return "redirect:/admin/usuario";
        }


        return "redirect:/admin/usuario";
    }
}
