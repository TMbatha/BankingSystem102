package za.ac.cput.repository;

import za.ac.cput.domain.Loan;
import java.util.List;

public interface ILoanRepository extends IRepository<Loan, String> {
    List<Loan> getAll();
}