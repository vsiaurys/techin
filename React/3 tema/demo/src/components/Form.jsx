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
      <div className="mb-3">
        <label className="form-label">Name: </label>
        <input {...register("name", { required: true, minLength: 2 })} />

        {errors?.name?.type === "required" && <span>The Name is required</span>}
        {errors?.name?.type === "minLength" && (
          <span>The Name must be at least 2 characters long</span>
        )}
      </div>

      <div className="mb-3">
        <label className="form-label">Gender (M or F): </label>
        <input
          {...register("sex", { required: true, pattern: /^(F|f|M|m)$/ })}
        />
        {errors?.sex?.type === "required" && (
          <span>The Gender is required</span>
        )}
        {errors?.sex?.type === "pattern" && (
          <span>The Gender can take only "M" or "F" value</span>
        )}
      </div>

      <div className="mb-3">
        <label className="form-label">Date of birth: </label>
        <input
          type="date"
          {...register("dateOfBirth", { required: true })}
        />
        {errors.dateOfBirth && <span>The Date of birth is required</span>}
      </div>

      <div className="mb-3">
        <label className="form-label">Height: </label>
        <input
          type="number"
          {...register("height", { required: true, min: 100, max: 250 })}
        />
        {errors?.height?.type === "required" && (
          <span>The Height is required</span>
        )}
        {errors?.height?.type === "min" && (
          <span>The Height must be at least 100 cm</span>
        )}
        {errors?.height?.type === "max" && (
          <span>The Height must be less than 250 cm</span>
        )}
      </div>

      <div className="mb-3">
        <label className="form-label">Rating: </label>
        <input
          type="number"
          step="0.1"
          {...register("rating", { required: true, min: 0, max: 10 })}
        />

        {errors?.rating?.type === "required" && (
          <span>The Rating is required</span>
        )}
        {errors?.rating?.type === "min" && (
          <span>The Rating must be in range from 0.0 to 10.0</span>
        )}
        {errors?.rating?.type === "max" && (
          <span>The Rating must be in range from 0.0 to 10.0</span>
        )}
      </div>

      <div className="mb-3">
        <label className="form-label">Salary per day: </label>
        <input
          type="number"
          {...register("salaryPerDay", { min: 0 })}
        />
        {errors.salaryPerDay && (
          <span>The Salary per day cannot be negative</span>
        )}
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
