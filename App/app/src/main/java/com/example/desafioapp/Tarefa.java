package com.example.desafioapp;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tarefaID",
        "nome",
        "concluido"
})
public class Tarefa {
    @JsonProperty("tarefaID")
    private Integer tarefaID;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("concluido")
    private boolean concluido;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tarefaID")
    public Integer getTarefaID(){
        return tarefaID;
    }

    @JsonProperty("tarefaID")
    public void setTarefaID(Integer id){
        this.tarefaID = id;
    }

    @JsonProperty("nome")
    public String getNome(){
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String Nome){
        this.nome = Nome;
    }

    @JsonProperty("concluido")
    public boolean getConcluido(){
        return concluido;
    }

    @JsonProperty("concluido")
    public void setConcluido(boolean conc){
        this.concluido = conc;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
