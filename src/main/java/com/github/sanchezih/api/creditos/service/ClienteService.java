package com.github.sanchezih.api.creditos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.api.creditos.entities.Cliente;
import com.github.sanchezih.api.creditos.repos.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> traerTodos() {
		return clienteRepository.findAll();
	}

	public boolean crearCliente(Cliente cliente) {
		if (existe(cliente.getNombre(), cliente.getDni())) {
			return false;
		}
		clienteRepository.save(cliente);
		return true;
	}

	public Cliente traerClientePorId(Integer id) {
		return clienteRepository.findByClienteId(id);
	}

	public boolean existePorId(Integer id) {
		Cliente cliente = clienteRepository.findByClienteId(id);
		return cliente != null;
	}

	public boolean existe(String nombre, int dni) {
		if (clienteRepository.existsByNombre(nombre) && clienteRepository.existsByDni(dni)) {
			return true;
		}
		return false;
	}

	public void actualizarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
