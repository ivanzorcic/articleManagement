FROM airhacks/wildfly
COPY ./target/articleManagement.war ${DEPLOYMENT_DIR}
