
import java.util.Scanner;

public class Car {
	private int id;
	private String name;
	private String color;
	private String type;
	private int yearOfManufacture;
	private Long price;
	private int amount;

	public Car() {
		super();
	}

	public Car(int id, String name, String color, String type, int yearOfManufacture, Long price, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.type = type;
		this.yearOfManufacture = yearOfManufacture;
		this.price = price;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", color=" + color + ", type=" + type + ", yearOfManufacture="
				+ yearOfManufacture + ", price=" + price + ", amount=" + amount + "]";
	}

	public void display() {
		System.out.println(this);
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new vehicle");
		System.out.print("Enter name: ");
		name = sc.nextLine();
		System.out.print("Enter color: ");
		color = sc.nextLine();
		System.out.print("Enter type: ");
		type = sc.nextLine();
		System.out.print("Enter year of manufacture: ");
		yearOfManufacture = sc.nextInt();
		System.out.print("Enter price: ");
		price = sc.nextLong();
		System.out.print("Enter amount: ");
		amount = sc.nextInt();
	}
}
