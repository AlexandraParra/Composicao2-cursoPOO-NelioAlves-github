import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.ItemPedido;
import entidade.Pedido;
import entidade.Produto;
import entidade.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de aniversário: ");
		Date dataAniversario = sdf.parse(sc.next());
		Cliente cliente = new Cliente(nome, email, dataAniversario);
		
		System.out.println("Dados do pedido: ");
		System.out.print("Status: ");
		sc.nextLine();
		StatusPedido status = StatusPedido.valueOf(sc.next());
		System.out.print("Quantos items deseja pedir? ");
		int n = sc.nextInt();
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do item #"+i+":");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto ");
			double preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			Produto produto = new Produto (nomeProduto, preco);
			ItemPedido item = new ItemPedido (quantidade, preco, produto);
			pedido.adicionarItem(item);
		}
		
		System.out.println();
		System.out.println("Resumo do pedido:");
		System.out.println("Momento do pedido: "+ sd.format(pedido.getMomento()));
		System.out.println("Status do pedido: "+pedido.getStatus());
		System.out.println("Cliente: "+pedido.getCliente());
		System.out.println("Lista de pedidos: ");
		for (ItemPedido item: pedido.getItems()) {
			System.out.println(item);
		}
		System.out.print("Total: "+ String.format("%.2f", pedido.total()));
		sc.close();

	}

}
