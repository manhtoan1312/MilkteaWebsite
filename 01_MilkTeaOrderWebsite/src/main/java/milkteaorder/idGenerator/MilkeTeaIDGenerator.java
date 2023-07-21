package milkteaorder.idGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MilkeTeaIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "MTEA";
		Connection connection = session.connection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select count(milk_tea_id) from milk_tea");
			if(rs.next()) {
				int id = rs.getInt(1) + 1;
				String generatedId = prefix + String.valueOf(id);
				return generatedId;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
}
