/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.rose.vagasweb.aut;


import br.edu.ifrs.restinga.rose.vagasweb.dao.UsuarioDAO;
import br.edu.ifrs.restinga.rose.vagasweb.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MeuUserDetailsService implements UserDetailsService {
    @Autowired
    UsuarioDAO usuarioDAO;
    @Override
    public UserDetails loadUserByUsername(String login) 
            throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException(login + " não existe!");
        }
        try {
        MeuUser meuUser = new MeuUser(usuario);    
        return meuUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
                return null;
        
    }
}
