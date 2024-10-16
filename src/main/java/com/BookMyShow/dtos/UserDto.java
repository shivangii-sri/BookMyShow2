package com.BookMyShow.dtos;

import com.BookMyShow.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private Location location;
    private String email;
    private String phone;
}
