function PNCRegistryBridge() {
    var context = window.context;
    if (typeof context === "undefined" && typeof FakePNCSmartRegistryContext !== "undefined") {
        context = new FakePNCSmartRegistryContext();
    }

    return {
        getClients: function () {
            return JSON.parse(context.get());
        },
        getVillages: function () {
            return JSON.parse(context.villages());
        }
    };
}

function FakePNCSmartRegistryContext() {
    return {
        get: function () {
            return JSON.stringify([
                {
                    entityId: "entity id 1",
                    village: 'Chikkabherya',
                    name: 'Carolyn',
                    thayi: '4636587',
                    ec_number: '314',
                    age: '24',
                    husband_name: 'Billy Bob',
                    weeks_pregnant: '18',
                    edd: '2013-04-28T00:00:00.000Z',
                    lmp: '2013-03-25',
                    alerts: [
                        {
                            name: 'ANC 4',
                            date: '24/07',
                            status: 'complete'
                        },
                        {
                            name: 'TT Booster',
                            date: '24/07',
                            status: 'urgent'
                        },
                        {
                            name: 'Hb Test 2',
                            date: '26/05',
                            status: 'normal'
                        },
                        {
                            name: 'IFA 2',
                            date: '26/05',
                            status: 'normal'
                        },
                        {
                            name: 'Delivery Plan',
                            date: '2012-05-18',
                            status: 'urgent'
                        }
                    ],
                    services_provided: [
                        {
                            name: 'TT 1',
                            date: '04/04',
                            data: {
                                dose: '80'
                            }
                        },
                        {
                            name: 'IFA',
                            date: '04/04',
                            data: {
                                dose: 100
                            }
                        },
                        {
                            name: 'IFA',
                            date: '05/04',
                            data: {
                                dose: 80
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-04-20',
                            data: {
                                hbLevel: 14
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-03-27',
                            data: {
                                hbLevel: 10
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-05-27',
                            data: {
                                hbLevel: 10
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-06-13',
                            data: {
                                hbLevel: 10
                            }
                        }
                    ],
                    days_due: '3',
                    due_message: 'Follow Up',
                    isHighPriority: true,
                    locationStatus: "out_of_area",
                    "photo_path": "../../img/woman-placeholder.png",
                    isHighRisk: true,
                    caste: "sc"
                },
                {
                    entityId: "entity id 2",
                    village: 'Chikkabherya',
                    name: 'Roger',
                    thayi: '4636587',
                    ec_number: '314',
                    age: '24',
                    husband_name: 'Jacck',
                    weeks_pregnant: '24',
                    edd: '2012-04-11T00:00:00.000Z',
                    lmp: '2013-03-25',
                    alerts: [
                        {
                            name: 'ANC 2',
                            date: '24/07',
                            status: 'normal'
                        },
                        {
                            name: 'TT 1',
                            date: '26/05',
                            status: 'urgent'
                        }
                    ],
                    services_provided: [
                        {
                            name: 'ANC 1',
                            date: '04/04',
                            data: {
                                bpSystolic: '120',
                                bpDiastolic: '79',
                                weight: '55'
                            }
                        },
                        {
                            name: 'IFA',
                            date: '04/04',
                            data: {
                                dose: 100
                            }
                        }
                    ],
                    days_due: '3',
                    due_message: 'Follow Up',
                    isHighPriority: true,
                    "photo_path": "../../img/woman-placeholder.png",
                    locationStatus: "left_the_place"
                },
                {
                    entityId: "entity id 3",
                    village: 'Bherya',
                    name: 'Larry',
                    thayi: '4636587',
                    ec_number: '314',
                    age: '24',
                    husband_name: 'Dickson',
                    weeks_pregnant: '2',
                    edd: '2013-09-11T00:00:00.000Z',
                    lmp: '2013-01-25',
                    "photo_path": "../../img/woman-placeholder.png",
                    alerts: [
                        {
                            name: 'ANC 2',
                            date: '24/05',
                            status: 'normal'
                        },
                        {
                            name: 'TT 1',
                            date: '26/05',
                            status: 'normal'
                        },
                        {
                            name: 'IFA 2',
                            date: '26/05',
                            status: 'complete'
                        }
                    ],
                    services_provided: [
                        {
                            name: 'ANC 1',
                            date: '04/04',
                            data: {
                                bpSystolic: '120',
                                bpDiastolic: '80',
                                weight: '55'
                            }
                        },
                        {
                            name: 'IFA',
                            date: '04/04',
                            data: {
                                dose: 100
                            }
                        },
                        {
                            name: 'IFA',
                            date: '04/04',
                            data: {
                                dose: 100
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-05-27',
                            data: {
                                hbLevel: 6
                            }
                        },
                        {
                            name: 'Delivery Plan',
                            date: '2012-09-13',
                            data: {
                                asha_name: 'Robin',
                                companion: 'Matt',
                                delivery_site: null,
                                transport: null,
                                contact_no: '9403292920',
                                review_risks: null
                            }
                        }
                    ],
                    days_due: '3',
                    due_message: 'Follow Up',
                    isHighPriority: true,
                    locationStatus: "in_area",
                    economicStatus: "bpl",
                    caste: "st"
                },
                {
                    entityId: "entity id 4",
                    village: 'Bherya',
                    name: 'Ukanga',
                    thayi: '4636587',
                    ec_number: '315',
                    age: '27',
                    husband_name: 'Harshit',
                    weeks_pregnant: '2',
                    edd: '2013-06-08T00:00:00.000Z',
                    "photo_path": "../../img/woman-placeholder.png",
                    lmp: '2012-09-13',
                    alerts: [
                        {
                            name: 'TT 2',
                            date: '26/05',
                            status: 'normal'
                        },
                        {
                            name: 'ANC 3',
                            date: '26/05',
                            status: 'urgent'
                        },
                        {
                            name: 'IFA 3',
                            date: '26/05',
                            status: 'urgent'
                        },
                        {
                            name: 'Delivery Plan',
                            date: '26/05',
                            status: 'upcoming'
                        }
                    ],
                    services_provided: [
                        {
                            name: 'ANC 2',
                            date: '04/08',
                            data: {
                                bpSystolic: '115',
                                bpDiastolic: '90',
                                weight: '98'
                            }
                        },
                        {
                            name: 'TT 1',
                            date: '04/04',
                            data: {
                                dose: 100
                            }
                        },
                        {
                            name: 'IFA',
                            date: '2012-04-24',
                            data: {
                                dose: 50
                            }
                        },
                        {
                            name: 'IFA',
                            date: '2012-05-24',
                            data: {
                                dose: 80
                            }
                        },
                        {
                            name: 'IFA',
                            date: '2012-06-17',
                            data: {
                                dose: 100
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-05-27',
                            data: {
                                hbLevel: 14
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-06-13',
                            data: {
                                hbLevel: 10
                            }
                        }
                    ],
                    days_due: '3',
                    due_message: 'Follow Up',
                    isHighPriority: false,
                    locationStatus: "in_area",
                    days_past_edd: 3
                },
                {
                    entityId: "entity id 5",
                    village: 'Bherya',
                    name: 'Moses',
                    thayi: '4636543',
                    "photo_path": "../../img/woman-placeholder.png",
                    ec_number: '429',
                    age: '35',
                    husband_name: 'Kiran',
                    weeks_pregnant: '5',
                    edd: '2013-05-11T00:00:00.000Z',
                    lmp: '25/3/13',
                    alerts: [
                        {
                            name: 'TT 2',
                            date: '26/05',
                            status: 'normal'
                        },
                        {
                            name: 'delivery_plan1',
                            date: '26/05',
                            status: 'normal'
                        }
                    ],
                    services_provided: [
                        {
                            name: 'ANC 1',
                            date: '04/04',
                            data: {
                                bpSystolic: '120',
                                bpDiastolic: '80',
                                weight: '95'
                            }
                        },
                        {
                            name: 'ANC 2',
                            date: '04/08',
                            data: {
                                bpSystolic: '115',
                                bpDiastolic: '90',
                                weight: '98'
                            }
                        },
                        {
                            name: 'TT 1',
                            date: '04/04',
                            data: {
                                dose: 100
                            }
                        },
                        {
                            name: 'IFA',
                            date: '2012-04-24',
                            data: {
                                dose: 50
                            }
                        },
                        {
                            name: 'IFA',
                            date: '2012-05-24',
                            data: {
                                dose: 20
                            }
                        },
                        {
                            name: 'IFA',
                            date: '2012-05-24',
                            data: {
                                dose: 20
                            }
                        },
                        {
                            name: 'Hb Test',
                            date: '2012-06-13',
                            data: {
                                hbLevel: 10
                            }
                        }
                    ],
                    days_due: '3',
                    due_message: 'Follow Up',
                    isHighPriority: false,
                    locationStatus: "in_area"
                }
            ]);
        },
        villages: function () {
            return JSON.stringify(
                [
                    {name: "bherya"},
                    {name: "chikkahalli"},
                    {name: "somanahalli_colony"},
                    {name: "chikkabherya"},
                    {name: "basavanapura"}
                ]
            )
        }
    };
}