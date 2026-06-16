package com.BankLoanManagement.entities;
 
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
 
//import com.fasterxml.jackson.annotation.JsonProperty;
 
@Entity
@Table(name = "loanapplication")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {

    @Id
    @Column(name = "ApplicationId")  
    private Integer applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_Id", nullable = false)  
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BankID", nullable = false)  
    private Banks bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LoanProductID", nullable = false) 
    private LoanProducts loanProduct;

    @Column(name = "LoanAmount", nullable = false)
    private Double loanAmount;

    @Column(name = "applicationDate", nullable = false)
    private LocalDate applicationDate;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

    public enum ApprovalStatus {
        PENDING, APPROVED, REJECTED
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "approvalStatus", nullable = false)
    private ApprovalStatus approvalStatus;
}