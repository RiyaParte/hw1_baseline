import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      try{
        double amount = view.getAmountField(); 
        String category = view.getCategoryField();

        // Input Validation
        InputValidation obj = new InputValidation();
        
        boolean isAmountValid = obj.validateAmount(amount);
        boolean isCategoryValid = obj.validateCategory(category);
        String message = "";

        if (isAmountValid && isCategoryValid) {
          
          // Create transaction object
          Transaction t = new Transaction(amount, category);

          // Call controller to add transaction
          view.addTransaction(t);
        }
        else{
          if (!isAmountValid){
          //amount is invalid
          message += "Please input an valid amount within the range 1 to 999.";
          }
          if (!isCategoryValid) {
            //category is invalid
            message += " Please input a valid category of types: Food, Travel, Bills, Entertainment, Other.";
          }
          view.showError(message);
        }


      }
      catch(NumberFormatException numberFormatException){
       view.showError("Please input an valid amount within the range 1 to 999");
      }
    });

  }

}