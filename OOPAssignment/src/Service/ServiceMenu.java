package Service;
public abstract class ServiceMenu {
   private String selection;


   public ServiceMenu(){

   }

   public ServiceMenu(String selection){
      this.selection = selection;
   }

   public String getSelection() {
      return selection;
   }

   public void setSelection(String selection) {
      this.selection = selection;
   }

   public static void displayServiceMenu(){
      System.out.println();
      System.out.printf("%78s","*************** Services Menu ***************\n");
      System.out.printf("%78s","=====================================================\n");
      System.out.printf("%79s","                  1.Transport Menu                      \n");
      System.out.printf("%79s","                  2.Foods Menu                     \n");
      System.out.printf("%79s","                  3.Beverage Menu                     \n");
      System.out.printf("%79s","                     4.Back                         \n");
      System.out.printf("%78s","======================================================\n");
      System.out.printf("%70s","      PLEASE SELECT THE MENU CATEGORY\n");
   }
}
