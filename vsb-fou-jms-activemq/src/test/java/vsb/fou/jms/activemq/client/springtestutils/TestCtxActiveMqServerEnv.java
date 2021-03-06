package vsb.fou.jms.activemq.client.springtestutils;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import vsb.fou.common.InfraConfig;

import javax.jms.ConnectionFactory;
import java.net.URI;

/**
 * @author Vegard S. Bye
 */
@Configuration
@InfraConfig
public class TestCtxActiveMqServerEnv {

    private static final String BROKER_URL = "vm://localhost";

    @Bean(destroyMethod = "destroy")
    public ConnectionFactory connectionFactory() throws Exception {
        SingleConnectionFactory bean = new SingleConnectionFactory();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        bean.setTargetConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean(destroyMethod = "stop")
    public BrokerService broker() throws Exception {
        BrokerService bean = new BrokerService();
        bean.setBrokerName("vsb-fou-test-broker");
        TransportConnector connector = new TransportConnector();
        connector.setEnableStatusMonitor(false);
        connector.setAuditNetworkProducers(false);
        connector.setUri(new URI(BROKER_URL));
        bean.addConnector(connector);
        bean.setPersistent(false);
        bean.setEnableStatistics(false);
        bean.start();
        return bean;
    }
}
