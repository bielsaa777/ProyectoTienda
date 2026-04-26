package views;

import java.util.Scanner;
import java.util.List;
import models.Cliente;
import dao.ClienteDAO;

public class ClienteView {
	private Scanner sc = new Scanner(System.in);
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public ClienteView() {}
	
	public void iniciar() {
		int opcion;
		do {
			opcion = this.mostrarMenu();
			switch(opcion) {
			case 1 -> this.listarClientes();
			case 2 -> this.addCliente();
			case 3 -> this.actualizarCliente();
			case 4 -> this.borrarCliente();
			}			
		} while (opcion != 5);
	}
	
	private void addCliente() {
		System.out.println("Introduce el nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce el email: ");
		String email = sc.nextLine();
		System.out.println("Introduce el teléfono: ");
		String telefono = sc.nextLine();
		
		Cliente c = new Cliente(nombre, email, telefono);
				
		if(this.clienteDAO.add(c)) {
			System.out.println("Cliente insertado correctamente");
		} else {
			System.out.println("Ha ocurrido un error");
		}
	}

	private void listarClientes() {
		List<Cliente> clientes = this.clienteDAO.getAll();
		System.out.println("\n-Lista de Clientes");
		for (Cliente c : clientes) {
			System.out.println(c);
		}
	}

	private void actualizarCliente() {
		System.out.println("Introduce el ID del cliente a actualizar: ");
		int id = sc.nextInt();
		sc.nextLine(); 
		
		System.out.println("Introduce el nuevo nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce el nuevo email: ");
		String email = sc.nextLine();
		System.out.println("Introduce el nuevo teléfono: ");
		String telefono = sc.nextLine();
		
		Cliente c = new Cliente(id, nombre, email, telefono);
				
		if(this.clienteDAO.update(c)) {
			System.out.println("Cliente actualizado correctamente");
		} else {
			System.out.println("Ha ocurrido un error");
		}
	}

	private void borrarCliente() {
		System.out.println("Introduce el ID del cliente a borrar: ");
		int id = sc.nextInt();
		sc.nextLine(); 
		
		if(this.clienteDAO.delete(id)) {
			System.out.println("Cliente borrado correctamente");
		} else {
			System.out.println("No se ha podido borrar el cliente");
		}
	}

	private int mostrarMenu() {
		System.out.println("Gestión de Clientes");
		System.out.println("1. Ver todos los clientes");
		System.out.println("2. Añadir cliente");
		System.out.println("3. Actualizar cliente");
		System.out.println("4. Borrar cliente");
		System.out.println("5. Volver al menú principal");		
		int opcion = sc.nextInt();
		sc.nextLine();
		
		return opcion;
	}
}