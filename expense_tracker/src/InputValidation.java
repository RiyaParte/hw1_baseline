public class InputValidation {

    public boolean validateAmount(double amount){

        if (0 < amount && amount<1000){
            return true;
        }

        return false;

    }

    public boolean validateCategory(String category){

        if(category.equalsIgnoreCase("food") || category.equalsIgnoreCase("travel") || category.equalsIgnoreCase("bills") || category.equalsIgnoreCase("entertainment") || category.equalsIgnoreCase("other")){
            return true;
        }
        return false;

    }
    
}
