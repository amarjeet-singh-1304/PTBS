public class Offering {

	private OfferingList offeringList;
	private String productType;

	private String name;

	private String productName;

	Offering(){}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productname) {
			this.productName = productname;
		}

	public String getProductType() {
			return productType;
		}

		public void setProductType(int id) {
			if(id == 1)
			{
				this.productType="Meat";
			}
			else
			{
				this.productType="Produce";
			}
		}

}
