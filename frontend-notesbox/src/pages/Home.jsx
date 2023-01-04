import React from "react";
import musical_box from "~/assets/images/musical_box_1.png";
import CategoryPicker from "~/shared/ui/shop/CategoryPicker";
import Category from "~/models/category";
import MusicalBox from "~/models/musicalBox";
import MusicalBoxGrid from "~/shared/ui/shop/MusicalBoxGrid";
import SecondaryButton from "~/shared/ui/input/SecondaryButton";
import { FaArrowRight } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

function Home() {
    const navigate = useNavigate();

    let homeCategories = [
        new Category(0, "Seasonal picks"),
        new Category(1, "Trending"),
        new Category(2, "Newest"),
    ];
    const boxes = [
        new MusicalBox(0, "Jingle Bells", "24", undefined, "Festive"),
        new MusicalBox(1, "Last Christmas", "24", undefined, "Festive"),
        new MusicalBox(2, "Muchachos", "29", undefined, "Sports"),
        new MusicalBox(3, "Arrancarmelo", "29", undefined, "Sports"),
        new MusicalBox(4, "Titanic", "29", undefined, "Movies"),
        new MusicalBox(5, "Mi Enfermedad", "29", undefined, "Other"),
    ];

    return (
        <main>
            <div className="flex gap-20 my-12 mx-96">
                <img
                    className="w-48 h-48"
                    src={musical_box}
                    alt="Musical box handrawing"
                />
                <div className="flex flex-col flex-grow max-w-md justify-center gap-4">
                    <h1>More than sound</h1>
                    <p className="text-justify">
                        Music is an essential part of our lives. Through it we
                        express emotions, share, and bring important moments
                        back to life. Through musical boxes, you can{" "}
                        <b>make them tangible.</b>
                    </p>
                </div>
            </div>
            <CategoryPicker
                className="my-6"
                showChooseText={false}
                categories={homeCategories}
            />
            <MusicalBoxGrid className="my-6" boxes={boxes} />
            <div className="flex justify-end my-12 w-1/2">
                <SecondaryButton
                    text="See the full catalog"
                    trailingIcon={<FaArrowRight />}
                    onClick={() => navigate("/catalog")}
                />
            </div>
        </main>
    );
}

export default Home;
