package br.com.nivlabs.gp.client.gtiss;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.nivlabs.gp.client.RestClientObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Objeto de Medicamentos da ANS
 * 
 * @author <a href="mailto:carolexc@gmail.com">Caroline Aguiar</a>
 * 
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Medicine extends RestClientObject {

	private static final long serialVersionUID = -2269808406417071745L;
	private String id;
	private String code;
	private String description;
	private String anvisaRegistration;
	private String presentation;
	private String laboratory;
	private String expirationStartDate;
	private String expirationDate;
	private String implantationEndDate;
}