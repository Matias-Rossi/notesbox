import React from "react";
import { useNavigate } from "react-router-dom";
import CategoryPicker from "~/shared/ui/shop/CategoryPicker";
import Category from "~/models/category";
import MusicalBoxGrid from "~/shared/ui/shop/MusicalBoxGrid";
import SecondaryButton from "~/shared/ui/input/SecondaryButton";
import { FaArrowRight } from "react-icons/fa";
import MusicalBox from "~/models/musicalBox";

function Catalog() {
    const navigate = useNavigate();

    let catalogCategories = [
        new Category(-1, "All"),
        new Category(1, "Festive"),
        new Category(2, "Classical"),
        new Category(3, "Sports"),
        new Category(4, "Movies"),
        new Category(5, "Other"),
    ];
    const boxes = [
        new MusicalBox(0, "Jingle Bells", "24", undefined, "Festive"),
        new MusicalBox(1, "Last Christmas", "24", undefined, "Festive"),
        new MusicalBox(2, "Muchachos", "29", undefined, "Sports"),
        new MusicalBox(3, "Arrancarmelo", "29", undefined, "Sports"),
        new MusicalBox(4, "Titanic", "29", undefined, "Movies"),
        new MusicalBox(5, "Mi Enfermedad", "29", undefined, "Other"),
        new MusicalBox(0, "Jingle Bells", "24", undefined, "Festive"),
        new MusicalBox(1, "Last Christmas", "24", undefined, "Festive"),
        new MusicalBox(2, "Muchachos", "29", undefined, "Sports"),
        new MusicalBox(3, "Arrancarmelo", "29", undefined, "Sports"),
        new MusicalBox(4, "Titanic", "29", undefined, "Movies"),
        new MusicalBox(5, "Mi Enfermedad", "29", undefined, "Other"),
    ];

    return (
        <main className="my-12 mb-auto">
            <CategoryPicker
                className="my-6 "
                showChooseText={true}
                categories={catalogCategories}
            />
            <MusicalBoxGrid className="my-6" boxes={boxes} />
            <div className="flex justify-end my-12 w-1/2">
                <SecondaryButton
                    text="See current trends"
                    trailingIcon={<FaArrowRight />}
                    onClick={() => navigate("/")}
                />
            </div>
        </main>
    );
}

export default Catalog;
