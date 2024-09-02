package core.jdbc;

public class BatchUPdateExample {

	public static void main(String[] args) {
		// 1. Create statement object
		Statement stmt = conn.createStatement();
		// 2. Turn off auto-commit
		con.setAutoCommit( false );
//			Create SQL statement
		String SQL ="INSERT INTO Employees (id, first, last, age)"
		+ "VALUES(100,‘Amr', ‘Mostafa', 45)"
		// 3. Add the above SQL statement in the batch stmt.addBatch(SQL);
		Create more SQL statements
		SQL ="INSERT INTO Employees (id, first, last, age)"
		+ "VALUES(101,‘Ahmed', ‘Mohamed', 35)"
		stmt.addBatch(SQL);
		SQL = "UPDATE Employees SET age = 35 " + "WHERE id = 100";
		stmt.addBatch(SQL);
		// 4. Execute the and hold the returned values int[] count = stmt.executeBatch();
		// 5. Explicitly commit statements to apply changes con.commit();


	}

}
