module  com.assignment.tictactoe.service{
    requires javafx.controls;
    requires javafx.fxml;

    exports com.assignment.tictactoe.service to javafx.fxml;
    opens com.assignment.tictactoe.service;
    exports com.assignment.tictactoe.service.Controller to javafx.fxml;
    opens com.assignment.tictactoe.service.Controller to javafx.fxml;
}