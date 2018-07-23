package mx.home.protobuf.main;

import mx.home.protobuf.generated.oneof.AddressBookProtos;
import mx.home.protobuf.generated.oneof.AddressBookProtos.AddressBook;
import mx.home.protobuf.generated.simple.AddressBookProtos.Contact;

public class MainProtobuf {
	
	/**
	 * Prueba de clases generadas por Protobuf
	 * @author Rodrigo Mendoza
	 * @since 23-07-2018
	 * @param args
	 */
	public static void main(String[] args) {
		// Usando únicamente message Contact
		Contact contactoPrueba = Contact.newBuilder()
				.setId(1)
				.setFirstName("Joe")
				.setLastName("Satriani")
				.setEmail("joesatriani@gmail.com")
				.setMobilePhone("5555555555")
				.build();
		
		System.out.println("-- Test simple Message");
		System.out.println(contactoPrueba.isInitialized());
		System.out.println(contactoPrueba.getEmail());
		System.out.println(contactoPrueba.getAddress());
		
		// Usando One Of
		mx.home.protobuf.generated.oneof.AddressBookProtos.Contact contactoOneOf = mx.home.protobuf.generated.oneof.AddressBookProtos.Contact.newBuilder()
				.setId(1)
				.setFirstName("Joe")
				.setLastName("Satriani")
				.setEmail("joesatriani@gmail.com")
				.setMobilePhone("4444")
				.setCellphone("2222")
				.build();
		
		System.out.println("-- Test Message using One Of");
		System.out.println(contactoOneOf.isInitialized());
		System.out.println(contactoOneOf.getEmail());
		System.out.println(contactoOneOf.getCellphone());
		System.out.println(contactoOneOf.getPhonesCase());
		System.out.println("-- End Message using Of");
		
		mx.home.protobuf.generated.oneof.AddressBookProtos.Contact contactDefault = mx.home.protobuf.generated.oneof.AddressBookProtos.Contact.getDefaultInstance();
		System.out.println("1: " + contactDefault);
		System.out.println("2: " + mx.home.protobuf.generated.oneof.AddressBookProtos.Contact.getDefaultInstance());
		System.out.println("3: " + mx.home.protobuf.generated.oneof.AddressBookProtos.Contact.getDefaultInstance().equals(contactDefault)); // Same object
		
		AddressBook addressBookOneOf = AddressBookProtos.AddressBook.newBuilder()
				.addContacts(contactoOneOf)
				.build();
		
		System.out.println(addressBookOneOf.toString());
	}
	
}
