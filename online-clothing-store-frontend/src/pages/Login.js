import React from "react";
import {
  Card,
  Container,
  CardHeader,
  CardBody,
  Form,
  FormGroup,
  Label,
  Input,
  Button,
  Row,
  Col,
} from "reactstrap";

const Login = () => {
  return (
    <div  style={{backgroundImage:"url('https://i.pinimg.com/564x/0c/32/20/0c3220f3a764b4629be937f81ada2cda.jpg')"}}>
    <Container className="py-5">
      <Row className="justify-content-center">
        <Col md="6">
          <Card>
            <CardHeader className="bg-dark text-light text-center">
              <h3>Login</h3>
            </CardHeader>
            <CardBody>
              <Form>
                <FormGroup>
                  <Label for="email">Email:</Label>
                  <Input
                    id="email"
                    type="email"
                    placeholder="Enter your email"
                  />
                </FormGroup>
                <FormGroup>
                  <Label for="password">Password:</Label>
                  <Input
                    id="password"
                    type="password"
                    placeholder="Enter your password"
                  />
                </FormGroup>
                <div className="d-grid">
                  <Button color="dark">Login</Button>
                </div>
              </Form>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
    </div>
  );
};

export default Login;
