package com.syncom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CODES")
public class Codes implements Serializable {

    @Id
    @Column(name = "CODE", unique = false, nullable = false)
    private String code;

    @Id
    @Column(name = "CODETYPE", unique = false, nullable = false)
    private String codeType;

    @Id
    @Column(name = "DETAIL", unique = false, nullable = false)
    private String detail;

    @Id
    @Column(name = "ADDL_CODE", unique = false, nullable = false)
    private String addlCodes;

    @Column(name = "ADDL_CODETYPE", unique = false, nullable = false)
    private String addlCodeType;
}
