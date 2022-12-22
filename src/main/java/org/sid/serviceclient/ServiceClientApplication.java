package org.sid.serviceclient;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Client.class);
		return  args -> {
		 	clientRepository.saveAll(
					List.of(
						Client.builder().
								name("Oussenou").email("ousseynou@gmail.com").tel(784219485).build(),
							Client.builder().name("Pata").email("laye@gmail.com").tel(784219485).build(),
							Client.builder().name("Omzo").email("Omzo@gmail.com").tel(784219485).build(),
							Client.builder().name("kheus").email("Kheus@gmail.com").tel(784219485).build(),
							Client.builder().name("Nassi").email("Nassiou@gmail.com").tel(784219485).build()
					)
			);
			 clientRepository.findAll().forEach(c->{
				 System.out.println(c);
			 });
		};
	}

}
