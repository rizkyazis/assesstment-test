package com.tabeldata.bootcamp.mappers;

public interface ObjectMapper<T1, T2> {
    T2 convertToDto(T1 var1);

    T1 convertToEntity(T2 var1);
}
