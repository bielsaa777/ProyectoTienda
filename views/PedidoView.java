package views;
import java.util.Scanner;
import java.util.List;
import models.Pedido;
import models.Producto;
import dao.PedidoDAO;
import dao.ProductoDAO;
public class PedidoView {

    private Scanner sc = new Scanner(System.in);
    private PedidoDAO pedidoDAO = new PedidoDAO();

public void iniciar() {
		int opcion;
		do {
			opcion = this.mostrarMenu();
			switch(opcion) {
			case 1 -> {
				this.ListarPedidos();
			}
			case 2 -> {
				this.addPedido();
			}
			}			
		} while (opcion != 5);
	}

    private void addPedido () {
        System.out.println("Introduce un id: ");
		int id = sc.nextInt();
		System.out.println("Introduce el id del cliente: ");
		int idCliente = sc.nextInt();
		System.out.println("Introduce una cantidad: ");
		int cantidad = sc.nextInt();
		System.out.println("Introduce una fecha: ");
        String fecha = sc.nextLine();
		Pedido p = new Pedido(id, idCliente, cantidad, fecha);
				
		if(this.PedidoDAO.add(p)) {
			System.out.println("Producto Insertado correctamente");
		} else {
			System.out.println("Ha ocurrido un error!");
		}
    }


    private void ListarPedidos() {
        List<Pedido> pedidos = this.PedidoDAO.getAll();

        for (Pedido p : pedidos) {
			System.out.println(p);
		}
    }

    private int mostrarMenu(){
        System.out.println("1. Listar pedidos");
        System.out.println("2. Agregar pedidos");
       int opcion = sc.nextInt();
       sc.nextLine();

       return opcion;
    }
}
