package com.feldmann.cursodespring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.feldmann.cursodespring.domain.Categoria;
import com.feldmann.cursodespring.domain.Cidade;
import com.feldmann.cursodespring.domain.Cliente;
import com.feldmann.cursodespring.domain.Endereco;
import com.feldmann.cursodespring.domain.Estado;
import com.feldmann.cursodespring.domain.ItemPedido;
import com.feldmann.cursodespring.domain.Pagamento;
import com.feldmann.cursodespring.domain.PagamentoComBoleto;
import com.feldmann.cursodespring.domain.PagamentoComCartao;
import com.feldmann.cursodespring.domain.Pedido;
import com.feldmann.cursodespring.domain.Produto;
import com.feldmann.cursodespring.domain.enums.EstadoPagamento;
import com.feldmann.cursodespring.domain.enums.TipoCliente;
import com.feldmann.cursodespring.repositories.CategoriaRepository;
import com.feldmann.cursodespring.repositories.CidadeRepository;
import com.feldmann.cursodespring.repositories.ClienteRepository;
import com.feldmann.cursodespring.repositories.EnderecoRepository;
import com.feldmann.cursodespring.repositories.EstadoRepository;
import com.feldmann.cursodespring.repositories.ItemPedidoRepository;
import com.feldmann.cursodespring.repositories.PagamentoRepository;
import com.feldmann.cursodespring.repositories.PedidoRepository;
import com.feldmann.cursodespring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	@Autowired
	private EstadoRepository estadorepository;
	
	@Autowired
	private CidadeRepository cidaderepository;
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private EnderecoRepository enderecorepository;
	
	@Autowired
	private PedidoRepository pedidorepository;
	
	@Autowired
	private PagamentoRepository pagamentorepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escrit??rio");
		Categoria cat3 = new Categoria(null,"Cama Mesa e Banho");
		Categoria cat4 = new Categoria(null,"Ferragem");
		Categoria cat5 = new Categoria(null,"Decora????o");
		Categoria cat6 = new Categoria(null,"Perfumaria");

		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",90.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6));
		produtorepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"S??o Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null,"S??o Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadorepository.saveAll(Arrays.asList(est1,est2));
		cidaderepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("996875532","998752345"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300","apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienterepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("20/04/2020 10:14"), cli1, e1);
		Pedido ped2 = new Pedido(null,sdf.parse("23/05/2020 10:18"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidorepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentorepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}

}
