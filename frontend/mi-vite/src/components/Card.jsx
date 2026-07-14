import "./Card.css";

function Card({title,value,icon}){
    return(
        <div className="card">
            <div className="card-icon">
                {icon}
            </div>
            <div>
                <h2>{value}</h2>
                <p>{title}</p>
            </div>
        </div>
    );
}

export default Card;