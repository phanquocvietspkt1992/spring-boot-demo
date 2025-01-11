package com.example.demo.mappers;

public interface Mapper<A,B> {

    B mapToDTO(A a);

    A mapToEntity(B b);

}
