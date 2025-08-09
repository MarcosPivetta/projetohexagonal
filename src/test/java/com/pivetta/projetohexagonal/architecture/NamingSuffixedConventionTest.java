package com.pivetta.projetohexagonal.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "com.pivetta.projetohexagonal")
public class NamingSuffixedConventionTest {

    // Classe para testar se as classes do projeto estão seguindo as convenções de nomenclatura dos pacotes

    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAnyPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer")
            .as("Classes no pacote consumer devem ser sufixadas com Consumer")
            .allowEmptyShould(true);
    @ArchTest
    public static final ArchRule should_be_suffixed_producer = classes()
            .that()
            .resideInAnyPackage("..producer")
            .should()
            .haveSimpleNameEndingWith("Producer")
            .as("Classes no pacote producer devem ser sufixadas com Producer")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAnyPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl")
            .as("Classes no pacote mapper devem ser sufixadas com Mapper ou MapperImpl")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_message = classes()
            .that()
            .resideInAnyPackage("..message")
            .should()
            .haveSimpleNameEndingWith("Message")
            .as("Classes no pacote message devem ser sufixadas com Message")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_controller = classes()
            .that().areAnnotatedWith(RestController.class)
            .or().resideInAnyPackage("..controller")
            .should().haveSimpleNameEndingWith("Controller")
            .as("Classes no pacote controller devem ser sufixadas com Controller")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_request = classes()
            .that()
            .resideInAnyPackage("..request")
            .should()
            .haveSimpleNameEndingWith("Request")
            .as("Classes no pacote request devem ser sufixadas com Request")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_response = classes()
            .that()
            .resideInAnyPackage("..response")
            .should()
            .haveSimpleNameEndingWith("Response")
            .as("Classes no pacote response devem ser sufixadas com Response")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_client = classes()
            .that()
            .resideInAnyPackage("..client")
            .should()
            .haveSimpleNameEndingWith("Client")
            .as("Classes no pacote client devem ser sufixadas com Client")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_entity = classes()
            .that()
            .resideInAnyPackage("..entity")
            .should()
            .haveSimpleNameEndingWith("Entity")
            .as("Classes no pacote entity devem ser sufixadas com Entity")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_adapter = classes()
            .that()
            .resideInAnyPackage("..adapter.out")
            .should()
            .haveSimpleNameEndingWith("Adapter")
            .as("Classes no pacote adapter.out devem ser sufixadas com Adapter")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_usecase = classes()
            .that()
            .resideInAnyPackage("..usecase")
            .should()
            .haveSimpleNameEndingWith("UseCase")
            .as("Classes no pacote usecase devem ser sufixadas com UseCase")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_input_port = classes()
            .that()
            .resideInAnyPackage("..ports.in")
            .should()
            .haveSimpleNameEndingWith("InputPort")
            .as("Classes no pacote ports.in devem ser sufixadas com InputPort")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_output_port = classes()
            .that()
            .resideInAnyPackage("..ports.out")
            .should()
            .haveSimpleNameEndingWith("OutputPort")
            .as("Classes no pacote ports.out devem ser sufixadas com OutputPort")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule should_be_suffixed_config= classes()
            .that()
            .resideInAnyPackage("..config")
            .should()
            .haveSimpleNameEndingWith("Config")
            .as("Classes no pacote config devem ser sufixadas com Config")
            .allowEmptyShould(true);
}
