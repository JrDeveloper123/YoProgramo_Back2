/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.serviceImpl;

import com.backEnd.portfolio_3.dto.PersonRequestDTO;
import com.backEnd.portfolio_3.dto.PersonResponseDTO;
import com.backEnd.portfolio_3.exception.PersonNotFoundException;
import com.backEnd.portfolio_3.model.Person;
import com.backEnd.portfolio_3.repository.PersonRepository;
import com.backEnd.portfolio_3.service.PersonService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    
        @Autowired
	private final PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	private PersonResponseDTO toDTO(Person person) {
		return PersonResponseDTO.builder().personId(person.getId())
				.name(person.getName()).surname(person.getSurname())
                                    .mail(person.getMail()).about(person.getAbout()).degree(person.getDegree())
                                            .address(person.getAddress()).phone(person.getPhone()).build();
	}
	
	private Person toEntity(PersonRequestDTO personDTO) {
		return Person.builder().name(personDTO.getName()).surname(personDTO.getSurname())
                        .mail(personDTO.getMail()).about(personDTO.getAbout()).degree(personDTO.getDegree())
                            .address(personDTO.getAddress()).phone(personDTO.getPhone()).build();
	}
	
	@Override
	public List<PersonResponseDTO> getAll() {
		return personRepository.findAll().stream().map(em -> toDTO(em)).collect(Collectors.toList());
	}

	@Override
	public PersonResponseDTO save(PersonRequestDTO personDTO) {
		Person newPerson= this.personRepository.save(toEntity(personDTO));
		return toDTO(newPerson);
	}

	@Override
	public PersonResponseDTO findById(Long personId) {
		Person person = this.personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId));
		return toDTO(person);
	}

	@Override
	public PersonResponseDTO update(PersonRequestDTO personDTO, Long personId) {
		return this.personRepository.findById(personId).map(p -> {
			p.setName(personDTO.getName());
			p.setSurname(personDTO.getSurname());
                        p.setMail(personDTO.getMail());
                        p.setAbout(personDTO.getAbout());
                        p.setDegree(personDTO.getDegree());
                        p.setAddress(personDTO.getAddress());
                        p.setPhone(personDTO.getPhone());
			return toDTO(personRepository.save(p));
		}).orElseGet(() -> {
			Person newPerson = toEntity(personDTO);
			newPerson.setId(personId);
			return toDTO(this.personRepository.save(newPerson));
		});
	}

	@Override
	public void delete(Long personId) {
		Person person = this.personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId));
		this.personRepository.delete(person);
	}

}