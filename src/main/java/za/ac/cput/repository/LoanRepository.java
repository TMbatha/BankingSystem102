package za.ac.cput.repository;

import za.ac.cput.domain.Loan;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository implements ILoanRepository {
    private static ILoanRepository repository = null;
    private List<Loan> loanList;

    private LoanRepository() {
        loanList = new ArrayList<>();
    }

    public static ILoanRepository getRepository() {
        if (repository == null) {
            repository = new LoanRepository();
        }
        return repository;
    }

    @Override
    public Loan add(Loan loan) {
        loanList.add(loan);
        return loan;
    }

    @Override
    public Loan read(String customerName) {
        // Find loan by customer's name
        for (Loan loan : loanList) {
            if (loan.getCustomer().getCustomerName().equalsIgnoreCase(customerName)) {
                return loan;
            }
        }
        return null;
    }

    @Override
    public Loan update(Loan updatedLoan) {
        String customerName = updatedLoan.getCustomer().getCustomerName();
        Loan oldLoan = read(customerName);
        if (oldLoan != null && delete(customerName)) {
            return add(updatedLoan);
        }
        return null;
    }

    @Override
    public boolean delete(String customerName) {
        Loan loanToDelete = read(customerName);
        return loanList.remove(loanToDelete);
    }

    @Override
    public List<Loan> getAll() {
        return loanList;
    }
}