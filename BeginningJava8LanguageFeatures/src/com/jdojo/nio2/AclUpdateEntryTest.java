// AclUpdateEntryTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.EnumSet;
import static java.nio.file.attribute.AclEntryPermission.READ_DATA;
import static java.nio.file.attribute.AclEntryPermission.WRITE_DATA;
		
public class AclUpdateEntryTest {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\poems\\luci1.txt");

		AclFileAttributeView aclView = 
			Files.getFileAttributeView(path, AclFileAttributeView.class);
		if (aclView == null) {
			System.out.format("ACL view is not supported.%n");
			return;
		}
		
		try {
			// Get UserPrincipal for brice  
			UserPrincipal bRiceUser = 
				FileSystems.getDefault()
				           .getUserPrincipalLookupService()
				           .lookupPrincipalByName("brice");

			// Prepare permissions set  
			Set<AclEntryPermission> permissions = EnumSet.of(READ_DATA, WRITE_DATA);
			
			// Let us build an ACL entry  
			AclEntry.Builder builder = AclEntry.newBuilder();
			builder.setPrincipal(bRiceUser);
			builder.setType(AclEntryType.ALLOW);
			builder.setPermissions(permissions);
			AclEntry newEntry = builder.build();
			
			// Get the ACL entry for the path  
			List<AclEntry> aclEntries = aclView.getAcl();
			
			// Add the ACL entry for brice to the existing list  
			aclEntries.add(newEntry);
			
			// Update the ACL entries  
			aclView.setAcl(aclEntries);		
			
			System.out.println("ACL entry added for brice successfully");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}			
	}
}
