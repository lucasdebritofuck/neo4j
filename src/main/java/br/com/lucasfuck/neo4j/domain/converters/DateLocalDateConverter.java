package br.com.lucasfuck.neo4j.domain.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

public class DateLocalDateConverter implements AttributeConverter<LocalDate, String> {

	private static final String DEFAULT_DATE = "yyyy-MM-dd";

	@Override
	public String toGraphProperty(LocalDate value) {
		if (value == null) {
			return null;
		}

		DateTimeFormatter formatters = DateTimeFormatter.ofPattern(DEFAULT_DATE);
		return value.format(formatters);
	}

	@Override
	public LocalDate toEntityAttribute(String value) {
		if (value == null) {
			return LocalDate.now();
		}

		return LocalDate.parse(value);
	}
}
