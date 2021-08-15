package br.net.glaubergad.personapidio.dto;


import br.net.glaubergad.personapidio.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {
    private Long id;

    private PhoneType type;

    private String number;
}
