package br.com.nivlabs.gp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nivlabs.gp.models.domain.DynamicQuestion;

@Repository
public interface DynamicFormQuestionRepository extends JpaRepository<DynamicQuestion, Long> {

}
