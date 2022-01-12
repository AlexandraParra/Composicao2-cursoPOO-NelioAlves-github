package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.enums.StatusPedido;

public class Pedido {
	private Date momento;
	private StatusPedido status;
	
	private Cliente cliente;
	private List <ItemPedido> items = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void adicionarItem (ItemPedido item) {
		items.add(item);
	}
	
	public void removeItem (ItemPedido item) {
		items.remove(item);
	}
	
	public Double total () {
		double total = 0;
		for (ItemPedido item : items) {
			total += item.subTotal();
		}
		return total;
	}
}
