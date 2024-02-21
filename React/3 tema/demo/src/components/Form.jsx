import { useForm } from "react-hook-form";

export default function Form() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    console.log(data);

    const postData = async () => {
      const send = await fetch("http://localhost:8080/actors", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb"),
        },
        body: JSON.stringify(data),
      });
    };

    postData();
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      {/* <input {...register("example", { required: true, minLength: 5 })} />
      {errors.example && (
        <span>This field should be at least 5 characters long</span>
      )}
      <input {...register("exampleRequired", { required: true })} />
      {errors.exampleRequired && <span>This field is required</span>}
      <input type="submit" /> */}
      <div className="mb-3">
        <label className="form-label">Name: </label>
        <input {...register("name")} />
      </div>
      <div className="mb-3">
        <label className="form-label">Gender: </label>
        <input {...register("sex")} />
      </div>
      <div className="mb-3">
        <label className="form-label">Date of birth: </label>
        <input
          type="date"
          {...register("dateOfBirth")}
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Height: </label>
        <input
          type="number"
          {...register("height")}
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Rating: </label>
        <input
          type="number"
          step="0.1"
          {...register("rating")}
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Salary per day: </label>
        <input
          type="number"
          {...register("salaryPerDay")}
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Link to a picture: </label>
        <input {...register("linkToPicture")} />
      </div>
      <button
        type="submit"
        className="btn btn-primary"
      >
        Submit
      </button>
    </form>
  );
}
