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

const Register = () => {
  return (
    <div style={{ backgroundImage: "url('https://i.pinimg.com/564x/0c/32/20/0c3220f3a764b4629be937f81ada2cda.jpg')" }} >
   <Container className="py-5" >
      <Row className="justify-content-center">
        <Col md="6">
          <Card>
            <CardHeader className="bg-dark text-light text-center">
              <h3>Register Yourself</h3>
            </CardHeader>
            <CardBody>
              <Form>
                <FormGroup>
                  <Label for="fname">First Name:</Label>
                  <Input
                    id="fname"
                    type="text"
                    placeholder="Enter your first name"
                  />
                </FormGroup>
                <FormGroup>
                  <Label for="lname">Last Name:</Label>
                  <Input
                    id="lname"
                    type="text"
                    placeholder="Enter your last name"
                  />
                </FormGroup>
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
                <FormGroup>
                  <Label for="cno">Contact No:</Label>
                  <Input
                    id="cno"
                    type="tel"
                    placeholder="Enter your contact number"
                  />
                </FormGroup>
                <FormGroup>
                  <Label for="gender">Gender:</Label>
                  <div>
                    <Label className="me-3">
                      <Input
                        type="radio"
                        name="gender"
                        value="male"
                      />
                      Male
                    </Label>
                    <Label className="me-3">
                      <Input
                        type="radio"
                        name="gender"
                        value="female"
                      />
                      Female
                    </Label>
                    <Label>
                      <Input
                        type="radio"
                        name="gender"
                        value="other"
                      />
                      Other
                    </Label>
                  </div>
                </FormGroup>
                <div className="d-grid">
                  <Button color="secondary" className="mt-2">Back to Login</Button>
                  <Button color="dark" className="mt-2">Register</Button>
                  <Button color="secondary" className="mt-2" type="reset">
                    Reset
                  </Button>
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

export default Register;

