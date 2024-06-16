# Car Dealership with a Database

In this project, the previous car dealership application has been updated to allow direct connectivity to a database. 
Rather than storing any vehicle information, customer information or contract information locally through csv files, the application now reads from and writes to a database using MySQL.

Since the application is pretty similar to its predecessor, I will be glossing over any unmodified menus and menu options and instead focus on new menu additions.

## Home Screen

#### The Home Screen is where users are greeted and prompted to:

- View all vehicles
- Browse vehicles by filter
- Manage vehicles
- Manage Sales and Leases

><details>
><summary> Home Screen </summary>
>
> ![HomeScreen](https://github.com/alyu15/WorkshopEight_CarDealershipDatabaseConnect/blob/de358650eac9c0c7ecefdc43beacab415cbf2cf9/images/HomeScreen.JPG)
>
></details>

## Manage Vehicles

#### If the user chooses 'Manage Vehicles', the user is able to modify the dealership's inventory of vehicles by:

- Adding a vehicle
- Update a vehicle
- Removing a vehicle

><details>
><summary> Manage Vehicles Screen </summary>
>
> ![ManageVehiclesScreen](https://github.com/alyu15/WorkshopEight_CarDealershipDatabaseConnect/blob/de358650eac9c0c7ecefdc43beacab415cbf2cf9/images/ManageVehiclesScreen.JPG)
></details>

If the user chooses 'Update a vehicle', they are first prompted to enter in the VIN of the vehicle they would like to update.
Afterwards, the user is shown a list which they are able to select from to update the vehicle based on the VIN they entered earlier.

><details>
><summary> Updating a Vehicle </summary>
>
> ![UpdatedVehicle](https://github.com/alyu15/WorkshopEight_CarDealershipDatabaseConnect/blob/de358650eac9c0c7ecefdc43beacab415cbf2cf9/images/UpdateVehicle.JPG)
></details>

## Manage Sales and Leases

#### If the user chooses 'Manage Sales and Leases', they are prompted to choose to access the dealership's sales contracts or lease contracts.

#### Afterwards, the user will be able to:

- View all sales or lease contracts
- Search for a specific sales or lease contract
- Create a new sales or lease contract
- Update an existing sales or lease contract
- Remove a sales or lease contract

><details>
><summary> Manage Sales and Leases Screen </summary>
>
> ![SalesAndLeasesScreen](https://github.com/alyu15/WorkshopEight_CarDealershipDatabaseConnect/blob/de358650eac9c0c7ecefdc43beacab415cbf2cf9/images/SalesAndLeasesScreen.JPG)
> 
> ![SalesContract](https://github.com/alyu15/WorkshopEight_CarDealershipDatabaseConnect/blob/de358650eac9c0c7ecefdc43beacab415cbf2cf9/images/SalesScreen.JPG)
></details>

## Interesting Piece of Code

```
 public Vehicle generateVehicleFromResultSet(ResultSet resultSet) throws SQLException {

        int vin = resultSet.getInt("vin");
        int year = resultSet.getInt("year");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        String type = resultSet.getString("type");
        String color = resultSet.getString("color");
        int odometer = resultSet.getInt("odometer");
        double price = resultSet.getDouble("price");
        String soldOrLeased = resultSet.getString("sold_or_leased");

        return new Vehicle(vin, year, make, model, type, color, odometer, price, soldOrLeased);
    }
```
I chose this piece of code because I felt like it played a big part in making my code look more neat. 
By using this piece of code, I was able to keep my code organized and prevent it from being repetitive.
I found it interesting because it's a simple return method that ended up doing so much and helping me a lot.

<br>
<div align="center">
<b>Thank you for taking the time out to check out my application!</b>

![Exit](https://github.com/alyu15/WorkshopEight_CarDealershipDatabaseConnect/blob/de358650eac9c0c7ecefdc43beacab415cbf2cf9/images/Exit.JPG)
</div>
