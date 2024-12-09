import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branch) {
        Branch branch1 = new Branch(branch);
        branches.add(branch1);
        return false;
    }

    public boolean addCustomer(String bName, String customerName, double initialTransaction){
        for (Branch branch : branches) {
            if (branch.getName().equals(bName)) {
                branch.newCustomer(customerName, initialTransaction);
                return true;

            }
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName,String customerName, double TransactionAmout){
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                branch.addCustomerTransaction(customerName, TransactionAmout);
                return true;
            }
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                System.out.println("Customer names for branch " + branch.getName());
                for (Customer customer : branch.getCustomers()) {
                    ArrayList<Double> localTransaction = customer.getTransactions();
                    if (showTransactions) {

                        System.out.println("Customer:"+customer.getName() + "\nTransactions: ");
                        for (int i = 0; i < localTransaction.size(); i++) {
                            System.out.printf("[%d] %.2f\n",i+1, localTransaction.get(i));
                        }
                    } else {
                        System.out.printf("%s\n",customer.getName());
                    }
                }

                return true;
            }

        }
        return false;
    }

}
