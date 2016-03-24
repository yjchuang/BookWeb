public class Book {
	private String sku;
	private String title;
	private String author;
	private String description;
	private double price;
	private boolean isInStock;

	public Book()
	{
		sku = "";
		title = "";
		author = "";
		description = "";
		price = 0.0;
		isInStock = true;
	}

	public Book(String _sku, String _title, String _author, String _description,
			double _price, boolean _isInStock)
	{
		sku = _sku;
		title = _title;
		author = _author;
		description = _description;
		price = _price;
		isInStock = _isInStock;
	}

	public String getDisplayText()
	{
		String author = getAuthor();
		String title = getTitle();
		String description = getDescription();
		return (author + title + description);
	}
	
	public boolean getIsInStock()
	{
		return isInStock;
	}
	public void setIsInStock(boolean _isInStock)
	{
		isInStock = _isInStock;
	}
	
	public String getSku()
	{
		return sku;
	}
	public void setSku(String _sku)
	{
		sku = _sku;
	}

	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String _author)
	{
		author = _author;
	}

	public String getTitle()
	{
		return title;
	}
	public void setTitle(String _title)
	{
		title = _title;
	}

	public String getDescription()
	{
		return description;
	}
	public void setDescription(String _description)
	{
		description = _description;
	}

	public double getPrice()
	{
		return price;
	}
	public void setPrice(double _price)
	{
		price = _price;
	}

}
