import React, { useState, useEffect } from "react";
import "./header.scss";
import { Link } from "react-router-dom";
import CommonModal from "../modal/CommonModal";
import { Button, Form } from "react-bootstrap";

const Header = () => {
  const [click, setClick] = useState(false);
  const [button, setButton] = useState(true);
  const [isShow, setIsShow] = useState(false);
  const [showModal, setShowModal] = useState(false);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const showButton = () => {
    if (window.innerWidth <= 960) {
      setButton(false);
    } else {
      setButton(true);
    }
  };

  useEffect(() => {
    showButton();
  }, []);

  window.addEventListener("resize", showButton);
  return (
    <>
      <nav className="navbar">
        <div className="navbar-container">
          <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
            <img src="/assets/images/logo2.png" alt="" title="logo" />
            <div>
              <span>Asean</span>
              <span>Weather</span>
            </div>
          </Link>
          <div className="menu-icon" onClick={handleClick}>
            <i className={click ? "fas fa-times" : "fas fa-bars"} />
          </div>
          <ul className={click ? "nav-menu active" : "nav-menu"}>
            <li className="nav-item">
              <Link to="/" className="nav-links" onClick={closeMobileMenu}>
                <i className="fas fa-search"></i>
                Find Location
              </Link>
            </li>

            <li className="nav-item">
              <Link
                to="#"
                className="nav-links"
                onClick={() => setIsShow(true)}
              >
                Sign In
              </Link>
            </li>
          </ul>
        </div>
      </nav>
      <CommonModal
        title="Modal Sign In"
        show={isShow}
        setIsShow={() => setIsShow(false)}
      >
        <div className="login-fb-wrap">
          <Button variant="primary" type="submit" className="mb-2 mt-2">
            <i className="fa fa-facebook fa-fw"></i>
            Login with Facebook
          </Button>
          <div className="mt-4 mb-2">
            <span>
              Are you Admin of Asean Weather?
              <Link to="#" onClick={() => setShowModal(true)}>
                SignIn
              </Link>
            </span>
          </div>
        </div>
      </CommonModal>

      <CommonModal
        title="SignIn Admin"
        show={showModal}
        setIsShow={() => setShowModal(false)}
      >
        <div className="row">
          <form action="">
            <div className="form-group ">
              <input
                type="email"
                className="form-control input-item  mb-4 mt-2"
                placeholder="Email..."
              />
            </div>

            <div className="form-group ">
              <input
                type="password"
                className="form-control input-item mt-4 mb-4"
                placeholder="Password..."
              />
            </div>

            <div className="form-group ">
              <button
                type="submit"
                className="btn btn-primary btn-block btn_submit mb-4 mt-4 "
              >
                Submit
              </button>
            </div>
          </form>
        </div>
      </CommonModal>
    </>
  );
};

export default Header;
