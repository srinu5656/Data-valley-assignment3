public class Organization implements Cloneable {
        private String organizationCode;
        private String organizationName;
        private String organizationAddress;
    
        public Organization(String organizationCode, String organizationName, String organizationAddress) {
            this.organizationCode = organizationCode;
            this.organizationName = organizationName;
            this.organizationAddress = organizationAddress;
        }
    
        // Getters and Setters
        public String getOrganizationCode() {
            return organizationCode;
        }
    
        public void setOrganizationCode(String organizationCode) {
            this.organizationCode = organizationCode;
        }
    
        public String getOrganizationName() {
            return organizationName;
        }
    
        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }
    
        public String getOrganizationAddress() {
            return organizationAddress;
        }
    
        public void setOrganizationAddress(String organizationAddress) {
            this.organizationAddress = organizationAddress;
        }
    
        // Method to print organization details
        public void printDetails() {
            System.out.println("Organization Code: " + organizationCode);
            System.out.println("Organization Name: " + organizationName);
            System.out.println("Organization Address: " + organizationAddress);
        }
    
        // Override clone method
        @Override
        public Organization clone() {
            try {
                return (Organization) super.clone();
            } catch (CloneNotSupportedException e) {
                // This should never happen, as we're Cloneable
                throw new InternalError(e);
            }
        }
    
        public static void main(String[] args) {
            // Creating an Organization object
            Organization originalOrg = new Organization("001", "ABC Corp", "123 Main St");
    
            // Cloning the original object
            Organization clonedOrg = originalOrg.clone();
    
            // Modifying cloned object's details
            clonedOrg.setOrganizationName("XYZ Corp");
            clonedOrg.setOrganizationAddress("456 Oak Ave");
    
            // Printing original object's details
            System.out.println("Original Organization:");
            originalOrg.printDetails();
    
            System.out.println();
    
            // Printing cloned object's details
            System.out.println("Cloned Organization:");
            clonedOrg.printDetails();
        }
    }
    

