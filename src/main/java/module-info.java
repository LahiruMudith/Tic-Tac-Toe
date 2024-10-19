module  com.assignment.tictactoe.service{
    requires javafx.controls;
    requires javafx.fxml;

    opens com.assignment.tictactoe.service;
    exports com.assignment.tictactoe.service;
    exports com.assignment.tictactoe.service.Controller;
    opens com.assignment.tictactoe.service.Controller to javafx.fxml;
}