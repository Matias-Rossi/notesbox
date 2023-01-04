import { useState } from "react";
import { Routes, Route } from "react-router-dom";
import Home from "~/pages/Home.jsx";
import Catalog from "~/pages/Catalog.jsx";
import Header from "~/shared/ui/header/Header.jsx";
import Footer from "~/shared/ui/footer/Footer.jsx";
import About from "~/pages/About.jsx";

function App() {
  return (
    <div className="App flex flex-col justify-between h-screen">
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/catalog" element={<Catalog />} />
        <Route path="/about" element={<About />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
