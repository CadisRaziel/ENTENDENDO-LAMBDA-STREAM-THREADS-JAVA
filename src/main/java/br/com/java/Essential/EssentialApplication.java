package br.com.java.Essential;

import br.com.java.Essential.Model.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class EssentialApplication {

    public static void main(String[] args) {

        SpringApplication.run(EssentialApplication.class, args);
		List<Cliente> clienteList = new ArrayList<>();
		Cliente cliente = new Cliente();

		//LAMBDA
		//implementação tradicional para apresentar todos os nomes dos clientes
		for(Cliente c : clienteList){
			System.out.println("o nome do cliente e: " + c.getNome());
		}

		//LAMBDA (->) para apresentar todos os nomes dos clientes
		clienteList.forEach(c -> System.out.println(c.getNome()));

//		- Lambda implementa uma interface funcional
//		- Executa o método funcional, a partir da sobrescrita do método accept (tipo Consumer);

		//---------------------------------------------------------------------

		//STREAM
		//implementação tradicional para buscar um dado em especifico
		for (Cliente c : clienteList) {
			if (c.getIdade() > 25) {
				System.out.println("Cliente tem mais que 25 anos: " + c.getNome());
			}
			if (c.getIdade() < 25) {
				System.out.println("Cliente tem menos que 25 anos: " + c.getNome());
			}
			if (c.getIdade() == 20) {
				System.out.println("Cliente tem 20 anos: " + c.getNome());
			}
		}

		//Implementação com Stream para buscar um dado especifico
		List<Cliente> collect = clienteList.stream().filter(c -> c.getIdade() > 25).collect(Collectors.toList());
		collect.forEach(c -> System.out.println(c.getNome()));

//		- São APIs que permite manipularmos as coleções de forma mais simples e prática
//		Coleções são listas.
//		- Streams, permite que o desenvolvedor aplique regras, como filtrar a partir dos dados do objeto

		//---------------------------------------------------------------------

		//THREADS
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					System.out.println("O runnable1 esta processando o: " + i);
				}
			}
		};
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					System.out.println("O runnable2 esta processando o: " + i);
				}
			}
		};

		new Thread(runnable1).start();
		new Thread(runnable2).start();

//		3-) Threads
//		Processamento Sincrono e Assincrono;
//		Processamento Sincrono -> exemplo: estamos em uma fila de restaurante que só atende uma pessoa por vez (ou seja um unico atendente para varias pessoas)(depende da ordem de chegada)
//		Processamento Assincrono ->  exemplo: estamos em uma fila de restaurante e tem mais que um atendente (Nao depende da ordem de chegada)

    }
}
