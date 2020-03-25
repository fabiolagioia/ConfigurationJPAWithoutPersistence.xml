package it.cybsec.configuration;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;

import it.cybsec.User;

public class ConfigurationJPA {
	public EntityManagerFactory createEntityManagerFactory() {
		final Properties props = new Properties();
		props.put("javax.persistence.jdbc.url",
				"jdbc:mysql://localhost:3306/usersdb?serverTimezone=UTC");
		props.put("javax.persistence.jdbc.user", "user");
		props.put("javax.persistence.jdbc.password", "YES");
		props.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.show_sql", "true");

		PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfo() {

			public String getPersistenceUnitName() {
				// TODO Auto-generated method stub
				return "TestUnit";
			}

			public String getPersistenceProviderClassName() {
				// TODO Auto-generated method stub
				return HibernatePersistenceProvider.class.getName();
			}

			public PersistenceUnitTransactionType getTransactionType() {
				// TODO Auto-generated method stub
				return null;
			}

			public DataSource getJtaDataSource() {
				// TODO Auto-generated method stub
				return null;
			}

			public DataSource getNonJtaDataSource() {
				// TODO Auto-generated method stub
				return null;
			}

			public List<String> getMappingFileNames() {
				// TODO Auto-generated method stub
				return null;
			}

			public List<URL> getJarFileUrls() {
				// TODO Auto-generated method stub
				return null;
			}

			public URL getPersistenceUnitRootUrl() {
				// TODO Auto-generated method stub
				return null;
			}

			public List<String> getManagedClassNames() {
				// TODO Auto-generated method stub
				return Arrays.asList(User.class.getName());
			}

			public boolean excludeUnlistedClasses() {
				// TODO Auto-generated method stub
				return false;
			}

			public SharedCacheMode getSharedCacheMode() {
				// TODO Auto-generated method stub
				return null;
			}

			public ValidationMode getValidationMode() {
				// TODO Auto-generated method stub
				return null;
			}

			public Properties getProperties() {
				// TODO Auto-generated method stub
				return props;
			}

			public String getPersistenceXMLSchemaVersion() {
				// TODO Auto-generated method stub
				return null;
			}

			public ClassLoader getClassLoader() {
				// TODO Auto-generated method stub
				return null;
			}

			public void addTransformer(ClassTransformer transformer) {
				// TODO Auto-generated method stub

			}

			public ClassLoader getNewTempClassLoader() {
				// TODO Auto-generated method stub
				return null;
			}

		};
		
		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();

		return hibernatePersistenceProvider
				.createContainerEntityManagerFactory(persistenceUnitInfo, Collections.EMPTY_MAP);

	}
}
